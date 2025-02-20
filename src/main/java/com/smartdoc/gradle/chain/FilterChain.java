/*
 * smart-doc https://github.com/shalousun/smart-doc
 *
 * Copyright (C) 2018-2023 smart-doc
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.smartdoc.gradle.chain;

import com.smartdoc.gradle.model.CustomArtifact;
import java.util.Objects;

/**
 * @author yu 2020/1/13.
 */
public interface FilterChain {

    /**
     * Set next filter chain
     * @param nextInChain Filter chain
     */
    void setNext(FilterChain nextInChain);

    /**
     * Ignore Artifact via ID
     * @param artifact Artifact
     * @return boolean
     */
    boolean ignoreArtifactById(CustomArtifact artifact);

    /**
     * FilterChain
     * @param nextInChain FilterChain
     * @param artifact CustomArtifact
     * @return boolean
     */
    default boolean ignore(FilterChain nextInChain, CustomArtifact artifact) {
        if (Objects.nonNull(nextInChain)) {
            return nextInChain.ignoreArtifactById(artifact);
        } else {
            return false;
        }
    }
}
