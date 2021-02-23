package com.example.notes;

public class Settings {
    public static final String SHARED_PREFERENCE_NAME = "FragmentNavigation";
    public static final String IS_BACK_STACK_USED = "UseBackStack";
    public static final String IS_ADD_FRAGMENT_USED = "UseAddFragment";
    public static final String IS_BACK_AS_REMOVE_FRAGMENT = "BackAsRemove";
    public static final String IS_DELETE_FRAGMENT_BEFORE_ADD = "DeleteFragmentBeforeAdd";

    public static boolean isBackStack;
    public static boolean isAddFragment;
    public static boolean isBackAsRemove;
    public static boolean isDeleteBeforeAdd;
    public static boolean IsBackStack;
    public static boolean IsAddFragment;
    public static boolean IsBackAsRemove;
    public static boolean IsDeleteBeforeAdd;


    public static boolean getIsBackAsRemove() {
        return (boolean) IsBackAsRemove;
    }

    public static void setIsBackAsRemove(Object isBackAsRemove) {
        IsBackAsRemove = (boolean) isBackAsRemove;
    }

    public static boolean getIsDeleteBeforeAdd() {
        return (boolean) IsDeleteBeforeAdd;
    }

    public static void setIsDeleteBeforeAdd(Object isDeleteBeforeAdd) {
        IsDeleteBeforeAdd = (boolean) isDeleteBeforeAdd;
    }

    public static boolean getIsAddFragment() {
        return (boolean) IsAddFragment;
    }

    public static void setIsAddFragment(Object isAddFragment) {
        IsAddFragment = (boolean) isAddFragment;
    }

    public static boolean getIsBackStack() {
        return (boolean) IsBackStack;
    }

    public static void setIsBackStack(Object isBackStack) {
        IsBackStack = (boolean) isBackStack;
    }

    public static class IsAddFragment {
    }

    public static class IsBackAsRemove {
    }

    public static class IsDeleteBeforeAdd {
    }

    public static class IsBackStack {
    }

}


