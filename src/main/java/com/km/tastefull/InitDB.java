package com.km.tastefull;

import com.km.tastefull.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct //로딩시점 호출
    public void init(){
        initService.dbInit1();
//        initService.dbInit2();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class  InitService{

        private final EntityManager em;
        public void dbInit1(){

            //Member 생성
            Preference preference = new Preference("Chianti Classico", "Cote du Rhone","South Italy", "Pinot noir","Shiraz","Sangiovese");
                Member member = new Member("nick@gmail.com", 25,"Male", "Italy",preference);
            em.persist(member);

            //Wine 생성
            Wine wine1 = new Wine("Calera", "United States","Central Coast","Red","Pinot Noir","Calera",2017,14.5);
            em.persist(wine1);

            Wine wine2 = new Wine("Calera", "United States","Central Coast","White","Chardonnay","Calera",2017,11.5);
            em.persist(wine2);

            Wine wine3 = new Wine("Rosso di Montalchino Leopoldo", "Italy","Tuscan","Red","Sangiovese","Tenuta Il Poggione",2018,14);
            em.persist(wine3);


            //Note 생성
            Palette palette = new Palette("Off-Dry","Low","Low","medium","Medium","Pronounced","Red fruit","pale","Cream","Long");

            LocalDateTime now = LocalDateTime.now();
            Note note = new Note("Medium","Pale Ruby", "Medium", "Red Cherry","Oak, Earth","Chocolate",palette,"OutStanding","맛있다 너무너무",now,20000,"한국유통");
            em.persist(note);

        }




//        public void dbInit2(){
//            Member member = createMember("userB", "진주", "2", "2222");
//            em.persist(member);
//
//            Book book1 = createBook("SPRING1 BOOK", 20000, 200);
//            em.persist(book1);
//
//            Book book2 = createBook("SPRING2 BOOK", 40000, 300);
//            em.persist(book2);
//
//            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
//            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);
//
//            Delivery delivery = createDelivery(member);
//            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
//            em.persist(order);
//        }
    }
}

