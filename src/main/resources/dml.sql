do $$
declare
	rDocUssr 		int;
	rDocRus			int;
	rDocInter		int;
	rDocDriver		int;
	rDocGardener	int;

	rClient1 int;
	rClient2 int;
	rClient3 int;
	rClient4 int;
	rClient5 int;

begin
	delete from client_reg_docs;
	delete from reg_doc_type;
	delete from client;

	insert into reg_doc_type(doc_code, doc_name) values ('10','Паспорт CCCP') returning id into rDocUssr;
	insert into reg_doc_type(doc_code, doc_name) values ('21','Паспорт РФ') returning id into rDocRus;
	insert into reg_doc_type(doc_code, doc_name) values ('27','Загран. паспорт') returning id into rDocInter;
	insert into reg_doc_type(doc_code, doc_name) values ('29','Водительское. удостоверение') returning id into rDocDriver;
	insert into reg_doc_type(doc_code, doc_name) values ('30','Удостоверени почетного садовода') returning id into rDocGardener;

	insert into client(full_Name, inn) values('Абдурахимов Баурхан', '1000000001')  returning id into rClient1;
	insert into client(full_Name, inn) values('Ермалаев Кузьма', '1000000002')  returning id into rClient2;
	insert into client(full_Name, inn) values('Гамза Богдан', '1000000003')  returning id into rClient3;
	insert into client(full_Name, inn) values('Елкин Вальдемар', '1000000004')  returning id into rClient4;
	insert into client(full_Name, inn) values('Пупкин Филип', '1000000005')  returning id into rClient5;

	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient1, rDocUssr, '1234', '666777', 'Выдан к 70-летия Октября');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient2, rDocRus	, '1255', '999881', 'Выдан в ЯНАО');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient3, rDocInter, '5235', '124588', 'Что бы ездить в Турцию');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient4, rDocDriver, '1234', '666777', 'Ездок как Шумахер');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient5, rDocGardener, '4455', '636747', 'СОНТ Елочка');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient3, rDocGardener, '6688', '626757', 'СОНТ Березка');
	insert into client_reg_docs(client_id, doc_type, ser, num, description) values(rClient2, rDocGardener, '7799', '166771', 'СОНТ Партизан');

end;
$$
;

select cl.*
	,  (  select string_agg('(' || rdt.doc_code || ') - ' || rdt.doc_name || ' - ' || crd.ser || ' ' || crd.num || ' ' || crd.description, ' ; ')
		  from client_reg_docs crd
		  join reg_doc_type rdt on rdt.id = crd.doc_type
		  where crd.client_id = cl.id
		  )	 as reg_docs
  from client cl
  ;


