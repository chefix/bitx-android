package com.twentytwoseven.android.bitxandroidsampleapp;

import com.twentytwoseven.android.bitx.model.OrderList;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListOrdersFragment extends ApiMethodFragment {

    @Override
    protected void execute() {
        ((MainActivity) getActivity()).getBitXClient().listOrders(new Callback<OrderList>() {
            @Override
            public void success(OrderList orderList, Response response) {
                String prettyJson = responseBodyInputStreamToString(response);
                mResultTextView.setText(prettyJson);
            }

            @Override
            public void failure(RetrofitError error) {
                handleFailure(error);
            }
        });
    }
}
