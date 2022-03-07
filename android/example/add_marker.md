
# Làm việc với các đối tượng bản đồ

SDK Android cung cấp nhiều phương thức để đánh dấu một điểm, vẽ một hình tròn, một đường thẳng giữa các điểm hay một đa giác các điểm. 
Thông thường bạn có thể vẽ lên trên bản đồ và trong vài trường hợp là bên trong của bản đồ.

## Điểm đánh dấu (Markers)

```java
// Khởi tạo một Icon object cho marker
 void  addConfigMarker(Style style ){
        style.addImage(markerName,
                BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this,R.drawable.ic_marker)),
                true);
    }

// Thêm marker vào bản đồ
SymbolOptions symbolOptions = new SymbolOptions()

                                    .withLatLng(new LatLng(10.758828246395028, 106.6757719352329))
                                    .withIconImage(markerName)
                                    .withIconSize(0.24f);

                            // Use the manager to draw the annotations.
                           Symbol symbol= symbolManager.create(symbolOptions);
```
## Bắt sự kiện marker

SDK cung cấp listener bắt sự kiện khi user nhấn vào marker. Mặc định, tất cả marker sẽ gọi sự kiện onMarkerClick để ẩn / hiện cửa sổ thông tin. 
Bạn có thể override và set listener mới bằng method onAnnotationClick


```java
symbolManager.addClickListener(new OnSymbolClickListener() {
                                @Override
                                public boolean onAnnotationClick(Symbol symbol) {
                                    Log.println(Log.DEBUG,"debug","onAnnotationClick: with id "+symbol.getId());
                                    return false;
                                }
                            });
```
## Update marker

Nếu bạn có ý định update marker thay vì loại bỏ nó, SDK cung cấp một vài method update.
 Ví dụ bạn có thể update vị trí mới hay icon mới cho marker

```java
// Change the marker location
symbolManager.update(symbol);

```

Tương tự ta có hàm **addPolyline để vẽ 1 line và **addPolygon để vẽ 1 đa giác