package com.fundamentosplatzi.springboot.fundamentos2;

import com.fundamentosplatzi.springboot.fundamentos2.bean.Been;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeenWithDependency;
import com.fundamentosplatzi.springboot.fundamentos2.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos2.emtity.User;
import com.fundamentosplatzi.springboot.fundamentos2.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos2.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Fundamentos2Application implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeenWithDependency myBeenWithDependency;

    private Been been;

    private MyBeanWithProperties myBeanWithProperties;

    private UserPojo userPojo;
    private final Log LOGGER = LogFactory.getLog(Fundamentos2Application.class);

    private UserRepository userRepository;


    public Fundamentos2Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeenWithDependency myBeenWithDependency, Been been, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
        this.componentDependency =componentDependency;
        this.myBean = myBean;
        this.myBeenWithDependency = myBeenWithDependency;
        this.been= been;
        this.myBeanWithProperties=myBeanWithProperties;
        this.userPojo=userPojo;
        this.userRepository=userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Fundamentos2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      ejemplosAnteriores();
        saveUsersInDataBase();
        getInformationJpqlFromUser();
    }

    private void getInformationJpqlFromUser(){
//        LOGGER.info("Usuario con el método findByUserEmail "+userRepository.findByUserEmail("Diego@email")
//                .orElseThrow(()-> new RuntimeException("No se encontró el usuario")));
//
//        userRepository.findAndSort("U", Sort.by("id").ascending())
//                .stream()
//                .forEach(user-> LOGGER.info("Usuario con método sort"+user));
//
//        userRepository.findByName("Jhon")
//                .stream()
//                .forEach(user -> LOGGER.info("Usuario con query method "+user));
//
//        LOGGER.info("usuario con query method findByEmailAndName "+userRepository.findByEmailAndName("Diego@email", "Diego")
//                .orElseThrow(()->new RuntimeException("Usuario no encontrado")));
//
//        userRepository.findByNameLike("%J%")
//                .stream()
//                .forEach(user -> LOGGER.info("Usuario findByNameLike"+user));
//
//
//        userRepository.findByNameOrEmail("Diego", null)
//                .stream()
//                .forEach(user -> LOGGER.info("Usuario findByNameOrEmail"+user));

        userRepository
                .findByBirthdateBetween(LocalDate.of(2021,3,1),LocalDate.of(2021,7,10) )
                .stream()
                .forEach(user -> LOGGER.info("Usuario con intervalo de fechas:"+user));

        userRepository.findByNameLikeOrderByIdDesc("%u%")
                .stream()
                .forEach(user -> LOGGER.info("Usuario encontrafdo con like y ordenaado "+user));

        userRepository.findByNameContainingOrderByIdAsc("u")
                .stream()
                .forEach(user -> LOGGER.info("Usuario encontrafdo con containing y ordenaado "+user));


    }

    private void saveUsersInDataBase(){
        User user1 = new User("Jhon","Jhon@email", LocalDate.of(2021, 03, 20));
        User user2 = new User("Diego","Diego@email", LocalDate.of(2002, 06, 30));
        User user3 = new User("Andres","Andres@email", LocalDate.of(2002, 05, 1));
        User user4 = new User("Jhon", "marisol@domain.com", LocalDate.of(2021, 6, 18));
        User user5 = new User("UKaren", "karen@domain.com", LocalDate.of(2021, 1, 1));
        User user6 = new User("UCarlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
        User user7 = new User("UEnrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
        User user8 = new User("ULuis", "luis@domain.com", LocalDate.of(2021, 2, 27));
        User user9 = new User("UPaola", "paola@domain.com", LocalDate.of(2021, 4, 10));
        User user10 = new User("UMaria", "maria@domain.com", LocalDate.of(2020, 6, 18));

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
        list.stream().forEach(userRepository::save);

    }

    public void ejemplosAnteriores(){
        componentDependency.saludar();
        myBean.print();
        myBeenWithDependency.printWithDependency();
        been.hola();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword()+"-"+userPojo.getAge());

        try{
            int value =10/1;
            LOGGER.debug("Mi valor es " + value);
        }catch (Exception e){
            LOGGER.error("Esto es un error al dividir po cero"+e.getMessage());
        }

    }
}
