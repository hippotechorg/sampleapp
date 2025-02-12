package com.example.SQL;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

public class SQLInjectionTest {

    @Test
    public void testUserList(){
        Scanner sc = new Scanner(System.in);
        List<String> usernameList = SQLInjection.getUserNames(sc.toString());
        assertNull(usernameList);
    }
    @Test
    public void testUserListwithAWSKEY(){
        String AWS_ACCESS_KEY_ID="XXXXXYYYYYZZZZ";
        List<String> usernameList = SQLInjection.getUserNames(AWS_ACCESS_KEY_ID);
        assertNull(usernameList);
    }
}
