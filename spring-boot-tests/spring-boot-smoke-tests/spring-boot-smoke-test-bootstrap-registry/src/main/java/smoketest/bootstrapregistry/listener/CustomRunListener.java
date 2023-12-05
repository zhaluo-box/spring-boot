/*
 * Copyright 2012-2023 the original author or authors.
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

package smoketest.bootstrapregistry.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * Created  on 2023/12/5 14:14:17
 *
 * @author wmz
 * @see org.springframework.boot.context.event.EventPublishingRunListener 即是监听者，也是发布者
 */
public class CustomRunListener implements SpringApplicationRunListener {

	/**
	 * 必须包含此构造器，并且还有两个构造参数，否则实例化报错。
	 */
	public CustomRunListener(SpringApplication application, String[] args) {
	}

	@Override
	public void starting(ConfigurableBootstrapContext bootstrapContext) {
		System.out.println("custom listener starting .....Spring 应用刚启动");
	}

	@Override
	public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
		System.out.println("custom listener environmentPrepared .....ConfigurableEnvironment 准备妥当，允许将其调整");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("custom listener contextPrepared .....ConfigurableApplicationContext 准备妥当，允许将其调整");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("custom listener contextLoaded .....ConfigurableApplicationContext 已装载，但仍未启动");
	}

	@Override
	public void started(ConfigurableApplicationContext context, Duration timeTaken) {
		System.out.println("custom listener started .....ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成");
	}

	@Override
	public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
		System.out.println("custom listener ready ..... spring 应用已准备好。");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("custom listener failed .....Spring 应用运行失败");
	}
}
