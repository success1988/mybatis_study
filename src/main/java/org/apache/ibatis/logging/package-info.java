/**
 *    Copyright 2009-2018 the original author or authors.
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
 * 基于适配器提供了日志工厂，同时对JDBC的对象做了代理增强，使其具有打印日志的功能
 * 适配器模式的作用：将一个接口转换成满足客户端期望的另一个接口，使得接口不兼容的那些类可以一起工作
 * 代理模式：给某一个对象提供一个代理，并由代理对象控制对原对象的访问引用。代理对象可以在原对象的基础上，进行一些功能上的增强，而这些增强对客户端来说是无感知的
 * Base package for logging.
 */
package org.apache.ibatis.logging;
