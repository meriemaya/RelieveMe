package com.e.releiveme.apiClient;

import com.e.releiveme.data.Models.User;
import com.squareup.otto.Bus;

public class BusProvider {

        private static final Bus BUS = new Bus();

        public static Bus getInstance(){
            return BUS;
        }

        public BusProvider(){}

}
