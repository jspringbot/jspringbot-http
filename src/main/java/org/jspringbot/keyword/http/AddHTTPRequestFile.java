/*
 * Copyright (c) 2012. JSpringBot. All Rights Reserved.
 *
 * See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The JSpringBot licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jspringbot.keyword.http;

import org.jspringbot.KeywordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@KeywordInfo(
        name = "Add HTTP Request File",
        parameters = {"name", "value"},
        description = "classpath:desc/AddHTTPRequestFile.txt"
)
public class AddHTTPRequestFile extends AbstractHTTPKeyword {

    @Autowired
    private ApplicationContext context;

    @Override
    public Object execute(Object[] params) throws IOException {
        String value = String.valueOf(params[1]);

        Resource resource = context.getResource(value);
        httpHelper.addFileParameter(String.valueOf(params[0]), resource.getFile());

        return null;
    }
}
