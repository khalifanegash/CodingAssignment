package se.ecutb.data;

import org.springframework.stereotype.Component;

@Component
public class IdSequencersImp implements IdSequencers {
    private  int personCounter;
    private  int todoCounter;
    @Override
    public int nextPersonId() {
        return ++personCounter;
    }

    @Override
    public int nextTodoId() {
        return ++todoCounter;
    }

    @Override
    public void clearPersonId() {

        personCounter = 0;
    }

    @Override
    public void clearTodoId() {

        todoCounter = 0;
    }
}
