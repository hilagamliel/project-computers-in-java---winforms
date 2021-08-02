/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagerguiview;

/**
 *
 * @author user1
 */
public class MyExpetion extends Exception{
    private String ex;
    public MyExpetion(String ex)
    {
        this.ex=ex;
    }

    @Override
    public String getMessage() {
        return ex;
    }
    
}
