package com.example.inventoryMaterial;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    //1. El usuario introduce un usuario o email

    //2. El usuario introduce una contraseña

    //3. El usuario existe en la base de datos

    //4. Que La contraseña sea correcta
    @Test
    public void SignIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);



    }

    //1. El usuario introduce un usuario

    //2. El usuario introduce un contraseña
    //3. El usuario introduce una email

    //4 La contraseña tiene que tener al menos 6 caracteres

    //5 El usuario no existe en la base de datos (Repository)
    //6 El email no existe en la base de datos (Repository)
    //7. Doble comprobación de la contraseña

    @Test
    public void SignUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }

}