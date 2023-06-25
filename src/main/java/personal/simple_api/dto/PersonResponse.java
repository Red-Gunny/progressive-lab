package personal.simple_api.dto;

import lombok.Builder;

@Builder
public class PersonResponse {
    String name;
    int age;
}
