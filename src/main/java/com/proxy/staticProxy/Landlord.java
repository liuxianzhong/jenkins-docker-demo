package com.proxy.staticProxy;

/**
 * 描述:
 *  房东
 * @outhor Calebit
 * @create 2020-09-25 8:43
 */
public class Landlord implements ILandlord {

    String houseName;//房屋名称
    int houseSellPrice;//房屋出售价格

    int houseLeasePrice;//房屋出租价格(单价)
    int houseLeaseTime;//最短出租时间

    @Override
    public String sell(int price) {
        if (price >= houseSellPrice) {
            return "我同意以" + price + "元的价格出售" + houseName;
        } else {
            return "我不同意以" + price + "元的价格出售" + houseName;
        }
    }

    @Override
    public String lease(int leaseTime, int price) {
        if (price < houseLeasePrice) {
            return "我不同意以" + price + "元的价格将" + houseName + "出租";
        }
        if (leaseTime < houseLeaseTime) {
            return "我不同意将" + houseName + "出租" + leaseTime + "个月";
        }
        return "我同意以" + price + "元的价格将" + houseName + "出租" + leaseTime + "个月";
    }

    public Landlord() {
    }

    public Landlord(String houseName, int houseSellPrice, int houseLeasePrice, int houseLeaseTime) {
        this.houseName = houseName;
        this.houseSellPrice = houseSellPrice;
        this.houseLeasePrice = houseLeasePrice;
        this.houseLeaseTime = houseLeaseTime;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public int getHouseSellPrice() {
        return houseSellPrice;
    }

    public void setHouseSellPrice(int houseSellPrice) {
        this.houseSellPrice = houseSellPrice;
    }

    public int getHouseLeasePrice() {
        return houseLeasePrice;
    }

    public void setHouseLeasePrice(int houseLeasePrice) {
        this.houseLeasePrice = houseLeasePrice;
    }

    public int getHouseLeaseTime() {
        return houseLeaseTime;
    }

    public void setHouseLeaseTime(int houseLeaseTime) {
        this.houseLeaseTime = houseLeaseTime;
    }


}
