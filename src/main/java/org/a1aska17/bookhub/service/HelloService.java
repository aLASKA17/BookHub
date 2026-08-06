package org.a1aska17.bookhub.service;

import org.a1aska17.bookhub.dto.AppInfoDto;
import org.a1aska17.bookhub.dto.AppMessageDto;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public AppInfoDto createAndReturnInfo() {
        AppInfoDto appInfoDto = new AppInfoDto();
        appInfoDto.setApplicationName("BookHub");
        appInfoDto.setJavaVersion("21");
        appInfoDto.setVersionApplication("1.0");
        return appInfoDto;
    }

    public AppMessageDto createAndReturnMessage() {
        AppMessageDto appMessageDto = new AppMessageDto();
        appMessageDto.setMessage("Welcome to BookHub");
        return appMessageDto;
    }
}
