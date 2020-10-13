/**
 *    Copyright 2009-2015 the original author or authors.
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
/**
 * 可以为JDBC接口记录日志的代理
 * 日志功能的优雅嵌入：MyBatis有个核心的组件Executor，主要的处理逻辑都是在Executor中实现的，日志的打印也是在这里，
 * 这里获取了ConnectionLogger后，后续的PreparedStatement、ResultSet也就会具备日志打印的功能了
 * @see org.apache.ibatis.executor.BaseExecutor#getConnection(org.apache.ibatis.logging.Log) 
 * Logging proxies that logs any JDBC statement.
 */
package org.apache.ibatis.logging.jdbc;
