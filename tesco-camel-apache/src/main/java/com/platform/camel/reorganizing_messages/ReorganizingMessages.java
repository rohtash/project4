/*
 * Copyright (C) Bilgin Ibryam http://www.ofbizian.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.platform.camel.reorganizing_messages;

import org.apache.camel.builder.RouteBuilder;

public class ReorganizingMessages extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:start")
                .resequence(header("message_index"))
                .batch().size(100).timeout(1000L)
                .to("mock:result");
    }

}
