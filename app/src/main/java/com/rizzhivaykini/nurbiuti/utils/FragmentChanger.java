package com.rizzhivaykini.nurbiuti.utils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.rizzhivaykini.nurbiuti.Fragments.AboutFragment;
import com.rizzhivaykini.nurbiuti.Fragments.BookingFragment;
import com.rizzhivaykini.nurbiuti.Fragments.ContactsFragment;
import com.rizzhivaykini.nurbiuti.Fragments.MainFragment;
import com.rizzhivaykini.nurbiuti.Fragments.ServicesFragment;


/**
 * Created by GrkRise on 08.07.2016.
 */

public class FragmentChanger {
    public static final int MAIN = 0;
    public static final int PRICE = 1;
    public static final int SERVICES = 2;
    public static final int DISCOUNT = 3;
    public static final int SETTINGS = 4;
    public static final int CONTACTS = 5;
    public static final int ABOUT = 6;
    public static final int TOPHIT = 7;


    private int id_fragment;
    private FragmentManager fragmentManager;
    public FragmentChanger(int id_fragment, FragmentManager fragmentManager) {
        this.id_fragment = id_fragment;
        this.fragmentManager = fragmentManager;
    }

    public void changer(int fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragment){
            case MAIN:{
                MainFragment mainFragment = new MainFragment();
                fragmentTransaction.replace(id_fragment, mainFragment)
                        .addToBackStack(null);
            }
            break;
            case PRICE:{

            }
            break;
            case SERVICES:{
                ServicesFragment servicesFragment = new ServicesFragment();
                fragmentTransaction.replace(id_fragment, servicesFragment);
            }
            break;
            case DISCOUNT:{}
            break;
            case SETTINGS:{}
            break;
            case CONTACTS:{
                ContactsFragment contactsFragment = new ContactsFragment();
                fragmentTransaction.replace(id_fragment, contactsFragment);
            }
            break;
            case ABOUT:{
                AboutFragment aboutFragment = new AboutFragment();
                fragmentTransaction.replace(id_fragment, aboutFragment);
            }
            break;
            case TOPHIT:{
                BookingFragment bookingFragment = new BookingFragment();
                fragmentTransaction.replace(id_fragment, bookingFragment);
            }
            break;

        }

        fragmentTransaction.commit();

    }
}
