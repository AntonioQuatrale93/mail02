package it.develhope.Mail02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NotificationDto {
    @NotNull
    private Long contactId;
    @NonNull
    private String title;
    @NotNull
    private String text;


}
