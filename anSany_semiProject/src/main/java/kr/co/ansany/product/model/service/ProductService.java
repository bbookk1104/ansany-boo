package kr.co.ansany.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.product.model.dao.ProductDao;
import kr.co.ansany.product.model.vo.Product;

public class ProductService {
	private ProductDao dao;
	
	public ProductService() {
		super();
		dao = new ProductDao();
	}
	
	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = dao.totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public ArrayList<Product> productMore(int start, int amount) {
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.moreProduct(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

	public Product selectOneProduct(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		Product p = dao.selectOneProduct(conn, productNo);
		JDBCTemplate.close(conn);
		return p;
	}


}
