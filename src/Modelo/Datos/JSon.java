package Modelo.Datos;

import netscape.javascript.JSObject;

public interface JSon<T> {

        public T AJson(T obj);//Aca le pasamos un objeto y lo hace una json
        public T EnJson(JSObject json);//aca le pasamos un json y lo hace un object

}
