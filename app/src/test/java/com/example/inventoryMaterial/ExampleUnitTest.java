package com.example.inventoryMaterial;

import com.example.inventoryMaterial.data.db.repository.UserRepository;
import com.example.inventoryMaterial.pojo.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Mock
    UserRepository userRepository = mock(UserRepository.class);
    private ArrayList<User> users;

    @Before
    public void initialice(){
    users = new ArrayList<User>();
    users.add (new User(4,"Helen1", "1234", "helen", "alex.x.ulom@gmail.com", true, false ));
    users.add(new User(5,"Helen2", "1234", "Helen2", "alex.x.ulom2@gmail.com", false, true ));
    users.add(new User(6,"Helen3", "1234", "Helen3", "alex.x.ulom3@gmail.com", false, false ));
    }



    //3. El usuario existe en la base de datos (Repository)
    // Para realizar en esta prueba tenemos que comprobar dos objetos de tipo user
    @Test
    public void isUserExists_isCorrect(){

        //Cuando llame al método isUserExists, devuelva un valor predeterminado
        when(userRepository.isUserExists(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExists(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect(){
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0),userRepository.getUsers().get(0));
    }


    //4. Que La contraseña sea correcta (Repository)
    @Test
    public void password_isCorrect(){
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals("1234",userRepository.getUsers().get(0).getPassword());
    }



    @Test
    public void testAssertions(){
        User user1 = new User(4,"Helen1", "1234", "helen", "alex.x.ulom@gmail.com", true, false );
        User user2=null;
        User user3 = user1;
        assertEquals(user1,users.get(0));

        //Un objeto es nulo
        assertNull(user2);

        //Un objeto no es nulo
        assertNotNull(user1);

        //Dos objetos apuntan a la misma referencia
        assertSame(user1,user3);
    }



    //5 El usuario no existe en la base de datos (Repository)
    //6 El email no existe en la base de datos (Repository)
    //7. Doble comprobación de la contraseña  (Repository)



}