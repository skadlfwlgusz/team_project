#cafe traders 서비스

>SRS(요구사항 명확화 )문서


##개요

'유저'와 '판매자'로 나눠 회원가입하여 , 
'유저'는 sns 처럼 서로의 글을 올리고 답글을 입력하여 소통하는 서비스이며. 좋아요를 누를수도 있고 유저의 글을 통해 주문하기가 가능하다.
'판매자'는 본인의 카페를 등록하여 판매할 수 있는 서비스이다.



###데이터스키마

-member사용자//스키마완성
-CEO사용자//스키마완성
-store //스키마완성
-order
-community
-menu
-good
-reply(댓글)
-review(매장리뷰)
-qna
-infrom(공지사항)
-filter  //스키마완성
-tag
-activity(활동내역)


####엔티티 스키마


####memberVO

id int(11) AI PK 
email_id varchar(45) 
password varchar(45) 
birth date 
phone varchar(45) 
point int(11) 
following varchar(512) 
created_at datetime 
updated_at datetime

####ceoVO

ceo_id int(11) AI PK 
ceo_email varchar(45) 
ceo_password varchar(45) 
ceo_birth datetime 
ceo_phone varchar(45) 
ceo_license varchar(45) 
created_at datetime
####storeVO
st_id int(11) AI PK 
ceo_id int(11) 
st_name varchar(45) 
st_pic varchar(512) 
st_inform varchar(128) 
st_place varchar(512) 
st_latlng varchar(128) 
st_post text 
st_mood int(11) 
st_zone varchar(256) 
created_at datetime 
updated_at datetime
####orderVO
or_id int(11) PK 
me_id varchar(20) 
id int(11) 
st_name varchar(45) 
or_sumprice int(11) 
or_quntity int(11) 
or_situation varchar(45) 
or_temper int(11) 
or_cup int(11) 
or_shot int(11) 
or_whip int(11) 
or_syrup int(11) 
created_at datetime

####menuVO
me_id int(11) PK 
st_id int(11) 
me_name varchar(45) 
me_price int(11) 
me_img varchar(512) 
me_temper tinyint(4) 
me_shot tinyint(4) 
me_whip tinyint(4) 
me_syrup tinyint(4) 
me_create_at datetime

####communityVO
com_id int(11) PK 
st_id int(11) 
id int(11) 
com_img varchar(512) 
com_content varchar(512) 
com_tag varchar(45) 
com_created_at datetime

####goodVO
id int(11) <<FK>>
com_id int(11) <<FK>>

####replyVO
rp_id int(11) PK FK
id int(11) 
com_id int(11) FK
rp_content varchar(512) 
rp_depth int(11) 
rp_sort int(11) 
rp_created_at datetime

####reviewVO
rv_id int(11) PK 
id int(11) FK
st_id int(11) FK
rv_content varchar(100) 
rv_star int(11) 
rv_created_at datetime

####informVO
in_id int(11) PK 
in_title varchar(45) 
in_content longtext 
in_created_at datetime
 
####filterVO
-fi_id(필터일련번호)
-fi_num(문자조합필터일련번호)
-fi_
####tagVO
id int(11) AI PK 
fi_num varchar(45) 
fi_mood varchar(45) 
fi_combination tinyint(4) 
created_at datetime

####activityVO
ac_id int(11) PK 
com_id int(11) FK
rp_id int(11)  FK
ac_subject varchar(45) 
ac_object varchar(45) 
ac_created_at datetime

## 주요기능
1.메인

2.회원가입가능(중복안됨)

2.회원이 로그인/로그아웃 가능

3.회원이 커뮤니티 입장 
로그인을 했다는 전제하에 진행한다.
-필터로 사용하여 분위기 리스트를 검색할 수 있다. 
-글쓰기 버튼을 클릭해 글작성(사진올리기, 글내용 작성, 태그첨부)할 수 있다.
-확인버튼을 누르면 글 내용이 완성된 페이지에 수정하기 버튼이 첨부된 페이지를 볼 수있다.
-매장으로 들어갈 수 있다.

4.store 입장
-지역별로 카페검색 하면 근처 카페가 검색된다.
-별점순, 리뷰가 많은 카페순으로 볼 수 있다.
-사진을 하나 클릭했을 때 카페상세보기가 가능하다.(위치정보 및 카페정보)
-메뉴보기가 가능하다.
-메뉴를 클릭했을 때 주문이 가능하다.
-주문 후 주문내역을 볼 수 있다.
-주문완료를 하면 결제창으로 넘어간다.
-결제내역을 볼 수 있다.

5. 공지사항
-admin이 공지사항을 올릴 수 있다.
-회원이 공지사항을 확인 할 수 있다.

6.마이페이지
-포인트를 확인할 수 있다.
-내 주문내역을 확인할 수 있다.
-내 활동로그를 확인할 수 있다.
-내가 쓴 글 리스트를 확인할 수 있다.
-내 정보리스트를 볼 수 있다.
-내 정보수정이 가능하다.

-------------------------------
<<판매자>>
2.회원가입가능(중복안됨)
3.매장관리
-매장등록이 가능하다
-매장수정이 가능하다.

4.가게운영
- 판매자가 주문내역 리스트를 볼 수 있다.
- 판매자가 주문 내역 상태를 변경할 수 있다.
- 판매자가 매출 리스트를 볼 수 있다.
- 판매자가 메뉴 리스트를 볼 수 있다.
- 판매자가 메뉴 업로드 할 수 있다.
- 판매자가 메뉴 수정을 할 수 있다.
- 판매자가 리뷰 리스트를 볼 수 있다. 

<<admin>>

/admin/*
- 어드민이 공지사항 리스트를 볼 수 있다.
- 어드민이 공지사항을 업로드 할 수 있다.
- 어드민이 공지사항을 수정할 수 있다.
- 어드민이 공지사항을 삭제할 수 있다.
- 어드민이 매출 리스트를 볼 수 있다.
- 어드민이 회원 리스트를 볼 수 있다.
- 어드민이 댓글 리스트를 볼 수 있다.
- 어드민이 댓글을 수정 할 수 있다.
- 어드민이 댓글을 삭제 할 수 있다. 



###url 맵핑
*.ct
1.메인

2.회원가입가능(중복안됨)
>join.ct(약관동의)
>join2.ct(회원정보입력)
>join_proc.ct(dao연동)

2.회원이 로그인/로그아웃 가능
>login.ct
>login_proc.ct

3.회원이 커뮤니티 입장 
- 비회원/회원이 커뮤니티 리스트를 볼 수 있다.
>commu_list.ct
- 회원이 커뮤니티 게시글을 작성할 수 있다.
>commu_add.ct
>commu_add_porc.ct
- 회원이 커뮤니티 게시글을 수정할 수 있다.
>commu_add.ct
>commu_add_porc.ct
- 회원이 커뮤니티 게시글을 삭제할 수 있다.
>commu_list.ct
- 회원이 커뮤니티 게시글에 댓글을 작성할 수 있다.
>commu_list.ct
- 회원이 커뮤니티 게시글에 댓글을 수정할 수 있다.
>commu_list.ct
- 회원이 커뮤니티 게시글에 댓글을 삭제할 수 있다.
>commu_list.ct
- 회원이 커뮤니티 게시글에 좋아요를 할 수 있다.
>commu_list.ct
- 비회원/회원이 매장 상세페이지를 볼 수 있다.
>sto_list.ct

4.store 입장
- 비회원/회원이 매장 리스트를 볼 수 있다.
> sto_list.ct
- 비회원/회원이 매장 검색을 할 수 있다.
> sto_list.ct
> sto_list_porc.ct
- 비회원/회원이 매장 지역 리스트를 볼 수 있다.
> sto_list.ct
- 비회원/회원이 매장 상세페이지를 볼 수 있다.
>sto_list_proc.ct
- 비회원/회원이 매장 매뉴 리스트를 볼 수 있다.
>sto_menu_list.ct
>sto_menu_list_proc.ct
- 회원이 매장 메뉴 주문 리스트를 볼 수 있다.
>sto_menu_order_list.ct
>sto_menu_order_list_proc.ct
- 회원이 매장 메뉴 주문 상세 페이지를 볼 수 있다.
>sto_menu_order_detail.ct
>sto_menu_order_detail_proc.ct
- 회원이 매장 메뉴 주문 확인 페이지를 확인 할 수 있다.
>sto_menu_order.ct
>sto_menu_order_proc.ct
5. 공지사항
- 회원이 공지사항 리스트를 볼 수 있다.
> member_inform_list.ct
- 회원이 공지사항 상세보기를 할 수 있다.
> member_inform.ct

6.마이페이지
-회원이 포인트를 확인할 수 있다.
>user.ct
-회원이 주문내역 리스트를 확인할 수 있다.
>user_orderlist.ct
-회원이 활동로그 리스트를 확인할 수 있다.
>user_log_list.ct
-회원이 작성한 게시글 리스트를 확인할 수 있다.
>user_comm_list.ct
-회원이 정보리스트를 볼 수 있다.
>user_inform_list.ct
-회원이 정보를 수정 할 수 있다.
>user_inform_edit.ct
>user_inform_edit_proc.ct

-------------------------------
<<판매자>>
2.회원가입가능(중복안됨)
3.매장관리
-매장등록이 가능하다
-매장수정이 가능하다.

4.가게운영
- 판매자가 주문내역 리스트를 볼 수 있다.
>ceo/order_list.ct
- 판매자가 주문 내역 상태를 변경할 수 있다.
>ceo/order_list_status.ct
- 판매자가 매출 리스트를 볼 수 있다.
>ceo/sale_list.ct
- 판매자가 메뉴 리스트를 볼 수 있다.
>ceo/menu_list.ct
- 판매자가 메뉴 업로드 할 수 있다.
> ceo/new_menu.ct
> ceo/new_menu_proc.ct
- 판매자가 메뉴 수정을 할 수 있다.
>ceo/menu_edit.ct
>ceo/menu_edit_proc.ct
- 판매자가 리뷰 리스트를 볼 수 있다. 
>ceo/review_list.ct

<<admin>>

/admin/*
- 어드민이 공지사항 리스트를 볼 수 있다.
/admin/inform_list.ct
- 어드민이 공지사항을 업로드 할 수 있다.
/admin/new_inform.ct
/admin/new_inform_proc.ct
- 어드민이 공지사항을 수정할 수 있다.
/admin/inform_edit.ct
/admin/infrom_edit_proc.ct
- 어드민이 공지사항을 삭제할 수 있다.
/admin/infrom.ct
- 어드민이 매출 리스트를 볼 수 있다.
/admin/sale_list.ct
- 어드민이 회원 리스트를 볼 수 있다.
/admin/member_list.ct
- 어드민이 회원을 수정할 수 있다.
/admin/member_edit.ct
/admin/member_edit_proc.ct
- 어드민이 회원을 삭제 할 수 있다.
/admin/menber_list.ct
- 어드민이 댓글 리스트를 볼 수 있다.
/admin/reply_list.ct
- 어드민이 댓글을 수정 할 수 있다.
/admin/reply_edit.ct
/admin/reply_edit_proc.ct
- 어드민이 댓글을 삭제 할 수 있다. 
/admin/reply_list.ct


##디렉터리 구조도

WebContent/
WebContent/CEOmanage
WebContent/common
WwebContent/community
WebContent/css/CEOmanage
WebContent/css/community
WebContent/css/join
WebContent/css/mypage
WebContent/css/sellor
WebContent/css/service
WebContent/css/store
WebContent/image/community
WebContent/image/follow
WebContent/image/home
WebContent/image/join
WebContent/image/login
WebContent/image/service
WebContent/image/store
WebContent/join
WebContent/js
WebContent/js/bxslider-4-4.2.12
WebContent/mypage
WebContent/pieces_txt
WebContent/sellor
WebContent/service
WebContent/store

### 패키지 구조도
src/
src/ct.dao
src/ct.dao.inf.IMemberDAO
src/ct.dao.inf.ICeoDAO
src/ct.dao.inf.IStoreDAO
src/ct.dao.inf.IOrderDAO
src/ct.dao.inf.ICommunityDAO
src/ct.dao.inf.IMenuDAO
src/ct.dao.inf.IGoodDAO
src/ct.dao.inf.IReplyDAO
src/ct.dao.inf.IReviewDAO
src/ct.dao.inf.IQnaDAO
src/ct.dao.inf.IInformDAO
src/ct.dao.inf.IFilterDAO
src/ct.dao.inf.ITagsDAO
src/ct.dao.inf.IActivityDAO

src/ct.dao.inf.MemberMysqlDAOimpl
src/ct.dao.inf.CeoMysqlDaoimpl
src/ct.dao.inf.StoreMysqlDaoimpl
src/ct.dao.inf.OrderMysqlDaoimpl
src/ct.dao.inf.CommunityMysqlDaoimpl
src/ct.dao.inf.MenuMysqlDaoimpl
src/ct.dao.inf.GoodMysqlDaoimpl
src/ct.dao.inf.ReplyMysqlDaoimpl
src/ct.dao.inf.ReviewMysqlDaoimpl
src/ct.dao.inf.QnaMysqlDaoimpl
src/ct.dao.inf.InformMysqlDaoimpl
src/ct.dao.inf.FilterMysqlDaoimpl
src/ct.dao.inf.TagsMysqlDaoimpl
src/ct.dao.inf.ActivityMysqlDaoimpl

src/ct.model.memberVO
src/ct.model.CEOVO
src/ct.model.storeVO
src/ct.model.orderVO
src/ct.model.communityVO
src/ct.model.menuVO
src/ct.model.goodVO
src/ct.model.replyVO
src/ct.model.reviewVO
src/ct.model.qnaVO
src/ct.model.infromVO
src/ct.model.filterVO  
src/ct.model.tagVO
src/ct.model.activityVO

src/ct.svc.controller.frontController

src/ct.svc.impl.MemberAddsvcimpl
src/ct.svc.inf.memberAddsvc

src/ct.svc.impl.MemberLogInOutsvcimpl
src/ct.svc.inf.memberLogInOutsvc


src/ct.svc.impl.CommunityEditsvcimpl
src/ct.svc.inf.CommunityEditsvc

src/ct.svc.impl.CommunityEditsvcimpl
src/ct.svc.inf.CommunityEditsvc

src/ct.svc.impl.CommunityEditsvcimpl
src/ct.svc.inf.CommunityEditsvc

src/ct.svc.impl.StoreOrderListsvcimpl
src/ct.svc.inf.StoreOrderListsvc

src/ct.svc.impl.StoreDetailListsvcimpl
src/ct.svc.inf.StoreDetailListsvc

src/ct.svc.impl.StoreOrderListsvcimpl
src/ct.svc.inf.StoreOrderListsvc

src/ct.svc.impl.StoreMenuOrdersvcimpl
src/ct.svc.inf.StoreMenuOrdersvc

src/ct.svc.impl.StoreOrderListsvcimpl
src/ct.svc.inf.StoreOrderListsvc

src/ct.svc.impl.UserEditsvcimpl
src/ct.svc.inf.UserEditsvc

src/ct.svc.impl.UserEditsvcimpl
src/ct.svc.inf.UserEditsvc

src/ct.svc.impl.CeoMenuAddsvcimpl
src/ct.svc.inf.CeoMenuAddsvc

src/ct.svc.impl.CeoMenuEditsvcimpl
src/ct.svc.inf.CeoMenuEditsvc

src/ct.svc.impl.CeoMenuAddsvcimpl
src/ct.svc.inf.CeoMenuAddsvc

src/ct.svc.impl.AdminInformAddsvcimpl
src/ct.svc.inf.AdminInformAdd

src/ct.svc.impl.AdminInformEditimpl
src/ct.svc.inf.AdminInformEditsvc

src/cvc.impl.AdminReplyEditimpl
src/cvc.inf.AdminReplyEditsvc

src/cvc.impl.AdminInformEditimpl
src/cvc.inf.AdminInformEditsvc

