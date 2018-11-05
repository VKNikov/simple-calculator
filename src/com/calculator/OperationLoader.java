package com.calculator;

import com.calculator.operation.Operation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperationLoader {

    private static final String OPERATIONS = "./resources/operations.txt";

    public Set<com.calculator.operation.Operation> load() {
        URL url = getClass().getResource(OPERATIONS);

        try {
            return parseAndLoadOperations(url);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't load class for operation. Program will terminate.");
            return null;
        } catch (URISyntaxException | NoSuchMethodException e) {
            System.out.println("Couldn't find path to operations. Program will terminate.");
            return null;
        } catch (IOException e) {
            System.out.println("Cannot read resources from hard drive. Program will terminate.");
            return null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return new HashSet<>();
    }

    private Set<com.calculator.operation.Operation> parseAndLoadOperations(URL url) throws URISyntaxException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        Set<com.calculator.operation.Operation> operations = new HashSet<>(4);
        for (String line : lines) {
            Class<?> currentOperation = Class.forName(line);
            Object operationInstance = currentOperation.getConstructor().newInstance();
            operations.add((Operation) operationInstance);
        }

        return operations;
    }

}
