package com.whx.test;

import org.junit.Test;
import com.whx.utils.newDdbUtils ;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class newDdbUtilsTest {


    @Test
    public void getConnection() {
        System.out.println(newDdbUtils.getConnection());
    }

    @Test
    public void commitAndClose() {
        newDdbUtils.commitAndClose();
    }

    @Test
    public void rollbackAndClose() {
        newDdbUtils.rollbackAndClose();
    }
}