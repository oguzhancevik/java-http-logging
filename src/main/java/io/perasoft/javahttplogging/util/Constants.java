package io.perasoft.javahttplogging.util;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Constants {

    public static final class SYSTEM {
        public static final ZoneId ZONE_ID = ZoneId.of("Europe/Istanbul");
        public static final TimeZone TIME_ZONE_ID = TimeZone.getTimeZone(ZONE_ID);
        public static final Locale LOCALE = new Locale("tr", "TR");
    }

    public static final class FILE {
        public static final String BASE_PACKAGE = "com.filemarket";
    }

    public static final class ENTITY {
        public static final String WHERE_CLAUSE = "deleted = false";
    }

    public static final class HTTP {
        public static final String REQUEST_ID_PROPERTY_NAME = "X-Request-Id";
        public static final List<String> SKIPPED_REQUEST_URI_LIST = Arrays.asList("swagger", "actuator");
    }

    public static final class LOG {
        public static final String ROOT_LOGGER = "root";
    }

    public static final class API {
        public static final String BASE_MAPPING = "/api";
    }

    public static final class EXCEPTION {
        public static final String DEFAULT_CODE = "SYSTEM";
    }

    public static final class SWAGGER {
        public static final String PATH_REGEX = "/api.*";
    }

}
