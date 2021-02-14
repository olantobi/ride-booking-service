package mt.com.ecabs.booking.producer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;
import mt.com.ecabs.booking.dto.Operation;
import mt.com.ecabs.booking.producer.dto.ApiResponseDto;
import mt.com.ecabs.booking.producer.service.MessagingService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/booking")
@RestController
@RequiredArgsConstructor
public class BookingController {
    private final MessagingService messagingService;

    @ApiOperation("Creates a new booking.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Booking created", response = ApiResponseDto.class),
            @ApiResponse(code = 400, message = "<li>Error if any of the mandatory fields were not filled.</li>" +
                    "<li>Error if the demand is greater than available resources.</li>", response = ApiResponseDto.class)
    })
    @PostMapping
    public ApiResponseDto<?> createBooking(final @Valid @RequestBody BookingDto booking) {
        messagingService.sendMessage(MessageWrapper.<BookingDto>builder()
                .operation(Operation.ADD)
                .message(booking)
                .build());

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
    public ApiResponseDto<?> editBooking(@PathVariable("id") long bookingId, final @Valid @RequestBody BookingDto bookingDto) {
        bookingDto.setId(bookingId);

        messagingService.sendMessage(MessageWrapper.<BookingDto>builder()
                .operation(Operation.EDIT)
                .message(bookingDto)
                .build());

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
        messagingService.sendMessage(MessageWrapper.<BookingDto>builder()
                .operation(Operation.DELETE)
                .message(BookingDto.builder().id(bookingId).build())
                .build());

        return ApiResponseDto.builder()
                .successful(true)
                .message("Booking has been deleted")
                .build();
    }
}
