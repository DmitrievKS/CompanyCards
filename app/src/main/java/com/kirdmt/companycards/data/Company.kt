package com.kirdmt.companycards.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*
[{"id":"1","name":"By Park Inn.Ижевск","img":"test_images/1.jpg"},{"id":"2","name":"The James Shark Pub","img":"test_images/2.jpg"},{"id":"3","name":"Дентал-Мед","img":"test_images/3.jpg"},{"id":"4","name":"Каприз","img":"test_images/4.jpg"},{"id":"5","name":"British-Баня","img":"test_images/5.jpg"},{"id":"6","name":"Лилия","img":"test_images/6.jpg"},{"id":"7","name":"Поехали!","img":"test_images/7.jpg"},{"id":"8","name":"Премьер","img":"test_images/8.jpg"},{"id":"9","name":"Red Bar","img":"test_images/9.jpg"},{"id":"10","name":"Жемчужина","img":"test_images/10.jpg"},{"id":"11","name":"Хангук","img":"test_images/11.jpg"},{"id":"12","name":"Золотая чаша","img":"test_images/12.jpg"},{"id":"13","name":"Пепино","img":"test_images/13.jpg"},{"id":"14","name":"Жили-Были","img":"test_images/14.jpg"},{"id":"15","name":"Форсаж","img":"test_images/15.jpg"}]*/

/*[{"id":"1",
    "name":"By Park Inn.Ижевск",
    "img":"test_images/1.jpg",
    "description":"By Park Inn\r\nПриглашаем посетить европейский ресторан, который является украшением международного отеля Park Inn by Radisson, находящегося на центральной площади столицы Удмуртии.\r\n\r\nЕвропейская кухня порадует гостей города и ценителей гармоничным вкусом и разнообразием выбора. Обширные площади ресторана позволят уютно расположиться большому количеству гостей. Банкетный зал располагает к тому, чтобы организовать официальный прием иностранных делегаций. Привлекательная обстановка доставит удовольствие гармонией стиля, утонченность интерьера усладит взор высоких гостей грациозным изяществом. Живая музыка подарит прекрасное настроение и оставит приятное послевкусие. Для удобства клиентов ресторан предоставляет свободный Wi-Fi. В теплое время открыта для посещения летняя терраса al Café, где вы сможете насладиться прохладительными напитками и яствами.\r\n\r\nОпытный шеф-повар представит все богатство выбора традиционной европейской кухни и нестандартные авторские блюда. Естественная европейская кухня славится широким ансамблем блюд из овощей и мяса с небольшим добавлением приправ и специй. Это способствует достижению оптимально насыщенного и естественного вкуса компонентов. Перед употреблением блюда рекомендуется заказать аперитив – какой-либо спиртной напиток – для повышения аппетита и лучшего усвоения пищи. \r\n\r\nОпределить наше точное местоположение поможет сайт Ижевска. С нетерпением ожидаем появления новых гостей.",
    "lat":56.85152,
    "lon":53.207789,
    "www":"www.sparta-fitness.ru",
    "phone":"+79875218872"}]*/

@Parcelize
data class Company(
    val id: String,
    val name: String,
    val img: String
) : Parcelable

data class CompanyResult(val results: List<Company>) {
    fun getList() = results
}

@Parcelize
data class CompanyDetails(
    val id: String,
    val name: String,
    val img: String,
    val description: String,
    val lat: String,
    val lon: String,
    val www: String,
    val phone: String
) : Parcelable

