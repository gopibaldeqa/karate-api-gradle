package dev.be.karate_demo_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.be.karate_demo_project.entity.KeyValueDto;
import dev.be.karate_demo_project.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/value")
    public String getValue(@RequestParam(required = false, defaultValue = "hello") String key) {
        return demoService.getValue(key);
    }

    @PostMapping("/value")
    public ResponseEntity addValue(@RequestBody KeyValueDto keyValueDto) {
        boolean isSuccess = demoService.addNewValue(keyValueDto.getKey(), keyValueDto.getValue());
        if (isSuccess) {
            return ResponseEntity.ok().body(Result.builder()
                                                  .isSuccess(true)
                                                  .key(keyValueDto.getKey())
                                                  .value(keyValueDto.getValue())
                                                  .build());
        } else {
            return ResponseEntity.badRequest()
                                 .body(Result.fail());
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    private static class Result {
        private boolean isSuccess;
        private String key;
        private String value;

        public static Result fail() {
            return builder().isSuccess(false).build();
        }
    }

}
