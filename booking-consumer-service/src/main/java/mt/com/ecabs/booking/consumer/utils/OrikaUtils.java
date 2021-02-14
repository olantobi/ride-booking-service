package mt.com.ecabs.booking.consumer.utils;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import mt.com.ecabs.booking.consumer.model.Booking;
import mt.com.ecabs.booking.consumer.model.TripWayPoint;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.TripWayPointDto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrikaUtils {

    private static MapperFactory getMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(BookingDto.class, Booking.class)
                .byDefault()
                .customize(new CustomMapper<BookingDto, Booking>() {
                    @Override
                    public void mapAtoB(BookingDto bookingDto, Booking booking, MappingContext context) {
                        booking.setPickupTime(bookingDto.getPickupTime());

                        booking.setTripWayPoints(new ArrayList<>());
                        for (TripWayPointDto tripWayPointDto : bookingDto.getTripWayPoints()) {
                            booking.addTripWayPoint(map(tripWayPointDto, TripWayPoint.class));
                        }
                    }
                }).register();
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
