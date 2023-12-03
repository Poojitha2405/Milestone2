package com.example.MI_Farmer;

public class CropModal {
    private String cropName;

    private String amount;
    private String price;
    private String subtotal;

    private String imgResource;
    private int id;

    // creating getter and setter methods
    public String getCropName() { return cropName; }

    public void setCropName(String cropName)
    {
        this.cropName = cropName;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getSubtotal() { return subtotal; }

    public void setSubtotal(String subtotal)
    {
        this.subtotal = subtotal;
    }

    public String getAmount() { return amount; }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getImgResource() { return imgResource; }

    public void setImgResource(String imgResource)
    {
        this.imgResource = imgResource;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public CropModal(String id, String cropName,
                     String price,
                     String subtotal, String amount, String imgResource)
    {
        this.id = Integer.parseInt(id);
        this.cropName = cropName;
        this.price = price;
        this.subtotal = subtotal;
        this.amount = amount;
        this.imgResource = imgResource;
    }
}

