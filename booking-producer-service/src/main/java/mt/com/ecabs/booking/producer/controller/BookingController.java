package mt.com.ecabs.booking.producer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.producer.dto.ApiResponseDto;
import mt.com.ecabs.booking.producer.service.BookingService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/booking")
@RestController
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @ApiOperation("Creates a new booking.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking created", response = ApiResponseDto.class),
            @ApiResponse(code = 400, message = "<li>Error if any of the mandatory fields were not filled.</li>" +
                    "<li>Error if the demand is greater than available resources.</li>", response = ApiResponseDto.class)
    })
    @PostMapping
    public ApiResponseDto<?> createBooking(final @Valid @RequestBody BookingDto booking) {
        bookingService.createBooking(booking);

        return ApiResponseDto.builder()
                .successful(true)
                .message("Your booking has been created")
                .build();
    }

    @ApiOperation("Edit a booking.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking updated", response = ApiResponseDto.class),
            @ApiResponse(code = 400, message = "<li>Error if any of the mandatory fields were not filled.</li>" +
                    "<li>Error if the demand is greater than available resources.</li>", response = ApiResponseDto.class)
    })
    @PutMapping("/{id}")
    public ApiResponseDto<?> editBooking(final @Valid @RequestBody BookingDto booking) {
        bookingService.createBooking(booking);

        return ApiResponseDto.builder()
                .successful(true)
                .message("Your booking has been updated")
                .build();
    }

    @ApiOperation("Deletes a booking.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking deleted", response = ApiResponseDto.class)
    })
    @DeleteMapping("/{id}")
    public ApiResponseDto<?> deleteBooking(@PathVariable("id") long bookingId) {
        bookingService.deleteBooking(bookingId);

        return ApiResponseDto.builder()
                .successful(true)
                .message("Booking has been deleted")
                .build();
    }

    @ApiOperation("Get all bookings.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking created", response = ApiResponseDto.class),
            @ApiResponse(code = 400, message = "<li>Error if any of the mandatory fields were not filled.</li>" +
                    "<li>Error if the demand is greater than available resources.</li>", response = ApiResponseDto.class)
    })
    @GetMapping
    public ApiResponseDto<?> getBookings() {
        List<BookingDto> allBookings = bookingService.getAllBookings();

        return ApiResponseDto.<List<BookingDto>>builder()
                .data(allBookings)
                .successful(true)
                .message("Bookings retrieved successfully")
                .build();
    }

    @ApiOperation("Get a booking")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking retrieved", response = ApiResponseDto.class),
            @ApiResponse(code = 400, message = "<li>Error if any of the mandatory fields were not filled.</li>" +
                    "<li>Error if the demand is greater than available resources.</li>", response = ApiResponseDto.class)
    })
    @GetMapping("/{id")
    public ApiResponseDto<?> getBooking(@PathVariable("id") long bookingId) {
        BookingDto bookingDto = bookingService.getBooking(bookingId);

        return ApiResponseDto.<BookingDto>builder()
                .data(bookingDto)
                .successful(true)
                .message("Booking retrieved successfully")
                .build();
    }
}
