/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.cache.decorators;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.cache.Cache;

/**
 * 最近最少使用
 * Lru (least recently used) cache decorator.
 *
 * @author Clinton Begin
 */
public class LruCache implements Cache {

  private final Cache delegate;
  private Map<Object, Object> keyMap;
  private Object eldestKey;//记录最近被移除的键

  public LruCache(Cache delegate) {
    this.delegate = delegate;
    //最多缓存1024个键值对
    setSize(1024);
  }

  @Override
  public String getId() {
    return delegate.getId();
  }

  @Override
  public int getSize() {
    return delegate.getSize();
  }

  public void setSize(final int size) {
    //LinkedHashMap的第三个参数accessOrder为true表示LinkedHashMap get （）方法会改变其记录的顺序,会保证操作过的Node节点永远在最后
    keyMap = new LinkedHashMap<Object, Object>(size, .75F, true) {
      private static final long serialVersionUID = 4267176411845948333L;

      /**
       * 当调用 LinkedHashMap put （）方法时，会调用该方法
       * 何为eldest？ 最早插入的键值对（insertion-ordered）  或 最少被访问的键值对（access-ordered）
       * @param eldest The least recently inserted entry in the map, or if this is an access-ordered map, the least recently accessed entry
       * @return 是否需要移除eldest键值对
       */
      @Override
      protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
        boolean tooBig = size() > size;
        if (tooBig) {//如果已到达缓存上限，则更新 eldestKey 字段， 后面在putObject方法中会删除该项
          eldestKey = eldest.getKey();
        }
        //长度超出，才需要移除最少访问的键值对
        return tooBig;
      }
    };
  }
  @Override
  public void putObject(Object key, Object value) {
    delegate.putObject(key, value);
    cycleKeyList(key);
  }
  @Override
  public Object getObject(Object key) {
    //LruCache getObject（）方法除了返回缓存项，还会调用 keyMap的get() 方法修改 key 的顺序，表示指定的 key 最近被使用。
    keyMap.get(key); //touch
    return delegate.getObject(key);
  }

  @Override
  public Object removeObject(Object key) {
    return delegate.removeObject(key);
  }

  @Override
  public void clear() {
    delegate.clear();
    keyMap.clear();
  }

  //【迎新辞旧】
  private void cycleKeyList(Object key) {
    keyMap.put(key, key);
    if (eldestKey != null) {//eldestKey 不为空，表示已经达到缓存上眼
      delegate.removeObject(eldestKey);//删除最久未使用的缓存项
      eldestKey = null;
    }
  }

}
