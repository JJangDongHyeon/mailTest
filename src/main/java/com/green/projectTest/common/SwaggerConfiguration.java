package com.green.projectTest.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "petmily테스뚜"
                , description = "집에서 잠깐"
                , version = "v0.000001"
        )
)
public class SwaggerConfiguration {
}
