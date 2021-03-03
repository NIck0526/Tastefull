package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "wine_note")
@NoArgsConstructor(access = AccessLevel.PROTECTED) /* 엔터티 객체를 생성한 뒤 setter를 독립적으로 생성못하게 막음 (createOrderItem)과 같이 메서드 생성하여 사용*/
public class WineNote {

    @Id @GeneratedValue
    @Column(name = "wine_note_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private Wine wine;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id")
    private Note note;

}
