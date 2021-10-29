/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.lang.Nullable;

/**
 * BeanDefinition是配置文件<bean>元素标签在容器中的对应内部表示形式
 * A BeanDefinition describes a bean instance, which has property values,
 * constructor argument values, and further information supplied by
 * concrete implementations.
 *
 * <p>This is just a minimal interface: The main intention is to allow a
 * {@link BeanFactoryPostProcessor} such as {@link PropertyPlaceholderConfigurer}
 * to introspect and modify property values and other bean metadata.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 19.03.2004
 * @see ConfigurableListableBeanFactory#getBeanDefinition
 * @see org.springframework.beans.factory.support.RootBeanDefinition
 * @see org.springframework.beans.factory.support.ChildBeanDefinition
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	// 可以看到默认只提供sington和prototype两种，
	// 其实还有request,session,globalSession,application,websocket这几种，不过它们属于基于web的扩展
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

	/** 不是很重要 */
	int ROLE_APPLICATION = 0;
	int ROLE_SUPPORT = 1;
	int ROLE_INFRASTRUCTURE = 2;

	// Modifiable attributes

	// 设置父Bean，这里涉及到bean继承，不是java继承。
	// 一句话就是：继承父Bean的配置信息而已
	void setParentName(@Nullable String parentName);

	/**
	 * 获取父bean
	 */
	@Nullable
	String getParentName();

	/** 设置Bean的类名称，将来是要通过反射来生成实例的 */
	void setBeanClassName(@Nullable String beanClassName);

	/** 获取类名称 */
	@Nullable
	String getBeanClassName();

	/** 设置bean的scope */
	void setScope(@Nullable String scope);

	/** 获取bean的scope */
	@Nullable
	String getScope();

	/** 设置是否懒加载 */
	void setLazyInit(boolean lazyInit);

	/** 获取bean的scope */
	boolean isLazyInit();

	// 设置该Bean依赖的所有的Bean，注意：这里的依赖不是指属性依赖(如 @Autowire 标记的)，
	// 是 depends-on="" 属性设置的值。
	void setDependsOn(@Nullable String... dependsOn);
	@Nullable
	String[] getDependsOn();

	// 设置该Bean是否可以注入到其他Bean中，只对根据类型注入有效，
	// 如果根据名称注入，即使这边设置了false，也是可以的
	void setAutowireCandidate(boolean autowireCandidate);
	boolean isAutowireCandidate();

	// 设置为优先的。同一接口的多个实现，如果不指定名字的话，Spring会优先选择设置primary为true的bean
	void setPrimary(boolean primary);

	/**
	 * Return whether this bean is a primary autowire candidate.
	 */
	boolean isPrimary();

	/**
	 * 如果该Bean采用工厂方法生成，指定工厂名称。对工厂不熟悉的读者，请参加附录
	 * 一句话就是：有些实例不是用反射生成的，而是用工厂模式生成的
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);

	@Nullable
	String getFactoryBeanName();

	/**
	 * 指定工厂类中的工厂方法名称
	 * Specify a factory method, if any. This method will be invoked with
	 * constructor arguments, or with no arguments if none are specified.
	 * The method will be invoked on the specified factory bean, if any,
	 * or otherwise as a static method on the local bean class.
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);

	@Nullable
	String getFactoryMethodName();

	/**
	 * 获取构造器参数
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the ConstructorArgumentValues object (never {@code null})
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/** 是否有构造器参数 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * Bean中的属性值，后面给bean注入属性值的时候会说到
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the MutablePropertyValues object (never {@code null})
	 */
	MutablePropertyValues getPropertyValues();

	/**
	 * Return if there are property values values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}


	// 下面是只读属性！！！！

	/** 是否单例 */
	boolean isSingleton();

	/** 返回是否prototype */
	boolean isPrototype();

	/** 如果这个Bean是被设置为abstract，那么不能实例化 */
	boolean isAbstract();

	/**
	 * Get the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	int getRole();

	/**
	 * Return a human-readable description of this bean definition.
	 */
	@Nullable
	String getDescription();

	/**
	 * Return a description of the resource that this bean definition
	 * came from (for the purpose of showing context in case of errors).
	 */
	@Nullable
	String getResourceDescription();

	/**
	 * Return the originating BeanDefinition, or {@code null} if none.
	 * Allows for retrieving the decorated bean definition, if any.
	 * <p>Note that this method returns the immediate originator. Iterate through the
	 * originator chain to find the original BeanDefinition as defined by the user.
	 */
	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
