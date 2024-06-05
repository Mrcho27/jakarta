package com.example.ee01.domain;

import lombok.*;

import java.time.LocalDate;

// vo: Value Object
// 값 그 자체를 표현하는 객체이다.
@Getter @Setter @ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
public class TodoVO {
    private Long todoId;
    private String content;
    private LocalDate todoDate;
    private boolean finished;
}
