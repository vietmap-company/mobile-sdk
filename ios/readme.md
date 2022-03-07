# Cài đặt  IOS SDK
SDK iOS là bộ thư viện cho iOS sử dụng OpenGL để hiển thị bản đồ đồng thời hỗ trợ tìm kiếm địa điểm và chỉ dẫn đường đi.
Nó là một phần của hệ sinh thái VietMap SDK

Là thư viện sử dụng OpenGL để hiển thị bản đồ và xử lý tương tác người dùng với bản đồ
Yêu cầu
* iOS 9.0+
* Xcode 8.0+

Setup project with SwiftUI
![](./img/img_1.png)

## Add Map Native SDK for iOS
* To add a package dependency to your Xcode project, select File > Swift Packages > Add Package Dependency

!["add swft package local"](./img/img_2.png)

![](./img/img_3.png)

![](./img/img_4.png)

![](./img/img_4.png)


## Create Map view
** In your project, add new SwiftUI View to the SimpleMap_SwiftUI folder and name it MapView.swift

I** In order to use native UIKit views in SwiftUI view, you must use [UIViewRepresentable](https://developer.apple.com/documentation/swiftui/uiviewrepresentable) wrapper. The instance of custom type which adopts UIViewRepresentable protocol is responsible for creation and management a UIView object in your SwiftUI interface.

     struct mapload: UIViewRepresentable {
         ...
     }
