package org.a1aska17.bookhub;

import org.a1aska17.bookhub.dto.AppInfoDto;
import org.a1aska17.bookhub.dto.AppMessageDto;
import org.a1aska17.bookhub.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {
    @InjectMocks
    private HelloService helloService;

    @Test
    void testReturnInfo() {
        AppInfoDto appInfoDto = helloService.createAndReturnInfo();
        assertNotNull(appInfoDto);
    }

    @Test
    void testReturnWelcomeMessage() {
        AppMessageDto appMessageDto = helloService.createAndReturnMessage();
        assertNotNull(appMessageDto);
    }
}
