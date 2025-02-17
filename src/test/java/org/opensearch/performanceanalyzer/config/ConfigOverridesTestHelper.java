/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.performanceanalyzer.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import org.opensearch.performanceanalyzer.commons.config.overrides.ConfigOverrides;

public class ConfigOverridesTestHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String RCA1 = "rca1";
    public static final String RCA2 = "rca2";
    public static final String RCA3 = "rca3";
    public static final String RCA4 = "rca4";
    public static final String ACTION1 = "act1";
    public static final String ACTION2 = "act2";
    public static final String ACTION3 = "act3";
    public static final String ACTION4 = "act4";
    public static final String DECIDER1 = "dec1";
    public static final String DECIDER2 = "dec2";
    public static final String DECIDER3 = "dec3";
    public static final String DECIDER4 = "dec4";
    public static final String COLLECTOR1 = "collector1";
    public static final String COLLECTOR2 = "collector2";
    public static final String COLLECTOR3 = "collector3";
    public static final String COLLECTOR4 = "collector4";
    public static final List<String> DISABLED_RCAS_LIST = Arrays.asList(RCA1, RCA2);
    public static final List<String> ENABLED_RCAS_LIST = Arrays.asList(RCA3, RCA4);
    public static final List<String> DISABLED_ACTIONS_LIST = Arrays.asList(ACTION1, ACTION2);
    public static final List<String> ENABLED_DECIDERS_LIST = Arrays.asList(DECIDER3, DECIDER4);
    public static final List<String> DISABLED_COLLECTORS_LIST =
            Arrays.asList(COLLECTOR1, COLLECTOR2);
    public static final List<String> ENABLED_COLLECTORS_LIST =
            Arrays.asList(COLLECTOR3, COLLECTOR4);

    public static ConfigOverrides buildValidConfigOverrides() {
        ConfigOverrides overrides = new ConfigOverrides();
        overrides.getDisable().setRcas(DISABLED_RCAS_LIST);
        overrides.getDisable().setActions(DISABLED_ACTIONS_LIST);
        overrides.getEnable().setRcas(ENABLED_RCAS_LIST);
        overrides.getEnable().setDeciders(ENABLED_DECIDERS_LIST);
        overrides.getEnable().setCollectors(ENABLED_COLLECTORS_LIST);
        overrides.getDisable().setCollectors(DISABLED_COLLECTORS_LIST);

        return overrides;
    }

    public static String getValidConfigOverridesJson() throws JsonProcessingException {
        return MAPPER.writeValueAsString(buildValidConfigOverrides());
    }

    public static String getInvalidConfigOverridesJson() throws JsonProcessingException {
        ConfigOverrides overrides = buildValidConfigOverrides();
        overrides.getDisable().setRcas(ENABLED_RCAS_LIST);
        return MAPPER.writeValueAsString(overrides);
    }
}
