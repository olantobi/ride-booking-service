package mt.com.ecabs.booking.consumer.utils;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class OrikaUtils {

    private static MapperFactory getMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(AllocatedIpAddress.class, AllocatedIpResponseDto.class)
                .fieldAToB("ipPool.id", "ipPoolId")
                .byDefault()
                .register();
        return mapperFactory;
    }

    public static <T> List<T> map(List<?> objects, Class<T> target) {
        MapperFactory mapperFactory = getMapperFactory();
        if (CollectionUtils.isEmpty(objects)) {
            return Collections.EMPTY_LIST;
        }
        return mapperFactory.getMapperFacade().mapAsList(objects.toArray(), target);
    }

    public static <T> T map(Object object, Class<T> target) {
        MapperFactory mapperFactory = getMapperFactory();

        return mapperFactory.getMapperFacade().map(object, target);
    }
}
