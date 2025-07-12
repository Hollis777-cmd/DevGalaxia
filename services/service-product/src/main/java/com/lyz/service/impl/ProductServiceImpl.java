package com.lyz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyz.dto.Result;
import com.lyz.mapper.ProductMapper;
import com.lyz.pojo.Product;
import com.lyz.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Result addProduct(Product product) {
        Boolean flag = this.save(product);
        if (flag) {
            return new Result(200, "添加成功", null);
        }
        return new Result(201, "添加失败", null);
    }

    @Override
    public Result deleteProduct(Integer id) {
        Boolean flag = this.removeById(id);
        if (flag) {
            return new Result(200, "删除成功", null);
        }
        return new Result(201, "删除失败", null);
    }

    @Override
    public Result updateProduct(Product product) {
        Boolean flag = this.updateById(product);
        if (flag) {
            return new Result(200, "修改成功", null);
        }
        return new Result(201, "修改失败", null);
    }

    @Override
    public Result getProductById(Integer id) {
        Product product = this.getById(id);
        if (product == null) {
            return  new Result(201,"查询失败",null);
        }
        return  new Result(200,"查询成功",product);
    }

    @Override
    public Result getProduct() {
        List<Product> products = this.list();
        if (products == null) {
            return  new Result(201,"查询失败",null);
        }
        return  new Result(200,"查询成功",products);
    }
}
