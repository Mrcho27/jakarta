package com.example.ee01.dto;

import com.example.ee01.domain.TodoVO;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter @ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TodoDTO {
    private Long todoId;
    private String content;
    private LocalDate todoDate;
    private boolean finished;

//    반복적으로 사용되는 기능을 만들어 쓰면 편하다.
//    DTO -> VO, VO -> DTO 변환하는 기능을 만들어 쓸 수도 있다.
//    public TodoVO toVO(){
//        return TodoVO.builder()
//                .content(content)
//                .todoDate(todoDate)
//                .finished(finished)
//                .build();
//    }
}
