package DesignPattern.build;

/**
 * Created by shs1329 on 2017/9/1.
 */
public class BuilderClient {
    int value;
    int temp;

    public BuilderClient(Builder builder) {
        this.value = builder.value;
        this.temp = builder.temp;
    }

    public static class Builder{
        int value;
        int temp;

        public Builder value(int value){
            this.value = value;
            return this;
        }


        public Builder temp(int temp){
            this.temp = temp;
            return this;
        }

        public BuilderClient build(){
            return new BuilderClient(this);
        }
    }
}
