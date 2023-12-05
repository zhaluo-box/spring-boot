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

package smoketest.bootstrapregistry.external.svn;

import org.springframework.boot.context.config.*;

import java.util.Collections;
import java.util.List;

/**
 * {@link ConfigDataLocationResolver} for subversion.
 *
 * @author Phillip Webb
 */
class SubversionConfigDataLocationResolver implements ConfigDataLocationResolver<SubversionConfigDataResource> {

	private static final String PREFIX = "svn:";

	/**
	 * 是否能够解析, 可以利用这个借口来验证资源的合法性
	 * @param context the location resolver context
	 * @param location the location to check.
	 * @return
	 */
	@Override
	public boolean isResolvable(ConfigDataLocationResolverContext context, ConfigDataLocation location) {
		return location.hasPrefix(PREFIX);
	}

	@Override
	public List<SubversionConfigDataResource> resolve(ConfigDataLocationResolverContext context, ConfigDataLocation location) throws
			ConfigDataLocationNotFoundException,
			ConfigDataResourceNotFoundException {
		String serverCertificate = context.getBinder().bind("spring.svn.server.certificate", String.class).orElse(null);
		return Collections.singletonList(new SubversionConfigDataResource(location.getNonPrefixedValue(PREFIX), serverCertificate));
	}

}
