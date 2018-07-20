package com.sankalpa.auction.model;

enum Status{
        READY,
        LIVE,
        SOLD,
        ABORTED
}

public class AuctionEvent {
        int id;
        int productId;
        int description;
        int auctioneerId;
//        Date startDate;
//        Date endDate;
        Status status;
}
