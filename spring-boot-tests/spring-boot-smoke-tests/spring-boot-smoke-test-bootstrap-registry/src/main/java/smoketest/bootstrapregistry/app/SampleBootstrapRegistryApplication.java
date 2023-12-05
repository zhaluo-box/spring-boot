/*
 * Copyright 2012-2021 the original author or authors.
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

package smoketest.bootstrapregistry.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import smoketest.bootstrapregistry.external.svn.SubversionBootstrap;

/**
 * 引导类
 */
@SpringBootApplication
public class SampleBootstrapRegistryApplication {

	public static void main(String[] args) {
		// This example shows how a Bootstrapper can be used to register a custom
		// SubversionClient that still has access to data provided in the
		// application.properties file
		//		SpringApplication application = new SpringApplication(SampleBootstrapRegistryApplication.class);
		//		application.addBootstrapRegistryInitializer(SubversionBootstrap.withCustomClient(MySubversionClient::new));
		//		application.run(args);

		SpringApplication application = new SpringApplicationBuilder().sources(SampleBootstrapRegistryApplication.class)
																	  .web(WebApplicationType.NONE)
																	  .addBootstrapRegistryInitializer(
																			  SubversionBootstrap.withCustomClient(MySubversionClient::new))
																	  .build();

		ConfigurableApplicationContext context = application.run(args);

		context.close();

	}

}
