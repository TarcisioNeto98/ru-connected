package com.tarcisio.ruconnected;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Context contexto;
    private Class classe;

    public Intent criarIntent(){
        Intent i = new Intent(this.contexto, this.classe);
        i.setAction(Intent.ACTION_VIEW);
        return i;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }
}
