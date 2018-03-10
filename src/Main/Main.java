package Main;

import DAO.UsersDao;
import entity.Users;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args)  {
        Login login =new Login();
        UsersDao usersDao =new UsersDao();
        ArrayList<Users> userlist = usersDao.getAllUser();
        for (Users u : userlist){
            if(u.getImage().equals("1")){
                java.util.Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                    login.jFrame.dispose();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                BooksShow b =new BooksShow(u.getUserName());
                            }
                        },100);
                    }},100);


                break;
            }
        }
    }
}
