package com.journeyfortech.e_commerce.data.model

data class Product(
    val color: String,
    val desc: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: Int
)

val products = listOf(
    Product(
        "#33505a",
        "Apple iPhone 12th generation",
        1,
        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-blue-hero?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1604021661000",
        "iPhone 12 Pro", 999
    ),
    Product(
        "#00ac51",
        "Google Pixel phone 5th generation",
        2,
        "https://cdn.dxomark.com/wp-content/uploads/medias/post-59199/google_pixel_5_frontback-1024x768.jpeg",
        "Pixel 5", 699
    ),
    Product(
        "#e0bfae",
        "Apple Macbook air with apple silicon",
        3,
        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp-spacegray-select-202011?wid=1280&hei=1190&fmt=jpeg&qlt=80&.v=1613672894000",
        "M1 Macbook Air", 1099
    ),
    Product(
        "#e3e4e9",
        "Apple Aipods Pro 1st generation",
        5,
        "https://crdms.images.consumerreports.org/c_lfill,w_598/prod/products/cr/models/400116-wireless-portable-headphones-apple-airpods-pro-10009323.png",
        "Airpods Pro", 200
    ),

    Product(
        "#f73984",
        "Apple iPad Pro 2020 edition",
        6,
        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-pro-12-select-wifi-silver-202003_FMT_WHH?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1583551131102",
        "iPad Pro", 799
    ),

    Product(
        "#1c1c1c",
        "Samsung Galaxy S21 Ultra 2021 edition",
        7,
        "https://lh3.googleusercontent.com/qRQPjHrhRVIs-xnfNSyiPXOH2vH97ylMacgbTKebqJtRfNH3LlYo8pN-5igsLDWUH62tGl5zNpTsl5xd8SprzGmXoCEmWFOi2-2cQVGS-r3PaRXHt62DmJHq-jrYX0UQvWZ9BA=s800-c",
        "Galaxy S21 Ultra", 1299
    ),

    Product(
        "#7c95eb",
        "Samsung Galaxy S21 2021 edition",
        7,
        "https://images.samsung.com/is/image/samsung/p6pim/za/galaxy-s21/gallery/za-clear-cover-galaxy-s21-5g-ef-qg991ttegww-363168624?\$720_576_PNG$",
        "Galaxy S21", 899
    ),

    Product(
        "#7c95eb",
        "Samsung Galaxy S21 2025 edition",
        8,
        "https://images.samsung.com/is/image/samsung/p6pim/za/galaxy-s21/gallery/za-clear-cover-galaxy-s21-5g-ef-qg991ttegww-363168624?\$720_576_PNG$",
        "Galaxy S21", 899
    ),


)