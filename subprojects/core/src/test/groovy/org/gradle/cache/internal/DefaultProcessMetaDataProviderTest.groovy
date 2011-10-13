/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.cache.internal

import spock.lang.Specification
import org.gradle.os.ProcessEnvironment

class DefaultProcessMetaDataProviderTest extends Specification {
    final ProcessEnvironment processEnvironment = Mock()
    final DefaultProcessMetaDataProvider provider = new DefaultProcessMetaDataProvider(processEnvironment)

    def "uses process PID as process identifier"() {
        given:
        _ * processEnvironment.maybeGetPid() >> 1234

        expect:
        provider.processIdentifier == '1234'
    }

    def "uses null when PID is not available"() {
        given:
        _ * processEnvironment.maybeGetPid() >> null

        expect:
        provider.processIdentifier == null
    }
}
