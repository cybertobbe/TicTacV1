package com.example.tictacv1;

import java.util.Random;

class fixedRandom extends Random {
    @Override
    public int nextInt(int origin, int bound) {

        return 1;
    }

}
